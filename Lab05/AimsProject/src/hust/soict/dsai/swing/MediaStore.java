package hust.soict.dsai.swing;

import hust.soict.dsai.aims.exception.PlayerException;

import javax.naming.LimitExceededException;
import javax.swing.*;
import hust.soict.dsai.aims.exception.PlayerException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cart.addMedia(media);

                    System.out.println(media.getTitle() + " is added to the cart.");

                    JOptionPane.showMessageDialog(MediaStore.this,
                            media.getTitle() + " is added to the cart.",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (LimitExceededException ex) {
                    JOptionPane.showMessageDialog(MediaStore.this,
                            "Error: The cart is full. " + ex.getMessage(),
                            "Limit error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        container.add(addToCartButton);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String message = ((Playable) media).play();

                        JOptionPane.showMessageDialog(MediaStore.this,
                                message,
                                "Đang phát: " + media.getTitle(), JOptionPane.INFORMATION_MESSAGE);

                    } catch (PlayerException ex) {
                        JOptionPane.showMessageDialog(MediaStore.this,
                                "Không thể phát: " + ex.getMessage(),
                                "Lỗi Phát Media", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(MediaStore.this,
                                "Xảy ra lỗi không xác định khi phát media.",
                                "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}