package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.exception.PlayerException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;
    private FilteredList<Media> filteredList;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediacategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;

    @FXML
    private Label lblTotalCost;

    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private ToggleGroup filterGroup;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonState(newValue);
                } else {
                    btnPlay.setDisable(true);
                    btnRemove.setDisable(true);
                }
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filterMedia(newValue);
            }
        });

        filterGroup.selectedToggleProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends javafx.scene.control.Toggle> observable,
                    javafx.scene.control.Toggle oldValue, javafx.scene.control.Toggle newValue) {
                filterMedia(tfFilter.getText());
            }
        });

        updateTotalCost();
        cart.getItemsOrdered().addListener(new ListChangeListener<Media>() {
            @Override
            public void onChanged(Change<? extends Media> c) {
                updateTotalCost();
            }
        });
    }

    private void updateButtonState(Media media) {
        btnRemove.setDisable(media == null);
        btnPlay.setDisable(!(media instanceof Playable));
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);

            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("The  \"" + selectedMedia.getTitle() + "\" is removed from the cart.");
            successAlert.showAndWait();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();

                Alert successAlert = new Alert(AlertType.INFORMATION);
                successAlert.setTitle("Playing Media");
                successAlert.setHeaderText("Playing: " + selectedMedia.getTitle());
                successAlert.setContentText("Playing Media. Please check the Console/Log.");
                successAlert.showAndWait();

            } catch (PlayerException e) {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("Error while playing Media");
                errorAlert.setHeaderText("Can't play Media: " + selectedMedia.getTitle());
                errorAlert.setContentText(e.getMessage());
                errorAlert.showAndWait();
            }
        }
    }

    private void filterMedia(String searchText) {
        filteredList.setPredicate(media -> {
            if (searchText == null || searchText.trim().isEmpty()) {
                return true;
            }

            String lowerCaseFilter = searchText.toLowerCase();

            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }

            else if (radioBtnFilterId.isSelected()) {
                String mediaId = String.valueOf(media.getId());
                return mediaId.contains(lowerCaseFilter);
            }

            return true;
        });
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert infoAlert = new Alert(AlertType.INFORMATION);
            infoAlert.setTitle("Notification");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Your cart is empty!");
            infoAlert.showAndWait();
            return;
        }

        Alert successAlert = new Alert(AlertType.INFORMATION);
        successAlert.setTitle("Order placed successfully");
        successAlert.setHeaderText("The order has been placed!");
        successAlert.setContentText("Total cost: " + String.format("%.2f $", cart.totalCost()) +
                "\nThanks for buying!");
        successAlert.showAndWait();

        cart.getItemsOrdered().clear();
        updateTotalCost();
    }
}