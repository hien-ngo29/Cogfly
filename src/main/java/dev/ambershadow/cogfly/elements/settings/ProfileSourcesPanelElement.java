package dev.ambershadow.cogfly.elements.settings;

import dev.ambershadow.cogfly.elements.SettingsDialog;

import javax.swing.*;
import java.awt.*;

public class ProfileSourcesPanelElement extends JPanel {
    public ProfileSourcesPanelElement(SettingsDialog parent) {
        JButton button = new JButton("Manage Profile Sources");
        button.addActionListener(_ -> {
            ManageProfileSourcesDialog dialog = new ManageProfileSourcesDialog(parent);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setVisible(true);
        });
        button.setPreferredSize(new Dimension(625, button.getPreferredSize().height));
        add(button);
    }
}
