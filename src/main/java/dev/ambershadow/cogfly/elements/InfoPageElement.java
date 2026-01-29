package dev.ambershadow.cogfly.elements;

import dev.ambershadow.cogfly.Cogfly;
import dev.ambershadow.cogfly.asset.Assets;
import dev.ambershadow.cogfly.util.Utils;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;

public class InfoPageElement extends JPanel {
    public InfoPageElement() {
        setLayout(new BorderLayout());

        JLabel image = new JLabel();
        ImageIcon icon = (ImageIcon)Assets.centralIcon.getAsIcon();
        Image scaled = icon.getImage().getScaledInstance(
                549, 336, Image.SCALE_SMOOTH);
        image.setIcon(new ImageIcon(scaled));
        image.setHorizontalAlignment(SwingConstants.CENTER);
        add(image, BorderLayout.CENTER);
        add(createButtons(), BorderLayout.SOUTH);
    }

    public JPanel createButtons(){
        JButton savesButton = new JButton("Open Saves Folder");
        savesButton.setIcon(Assets.openSaves.getAsIconWithColor(Color.RED));
        savesButton.setHorizontalAlignment(SwingConstants.LEFT);
        savesButton.addActionListener(_ -> Utils.openSavePath());

        JButton logsButton = new JButton("Open Logs Folder");
        logsButton.setIcon(Assets.openSaves.getAsIconWithColor(Color.BLUE));
        logsButton.setHorizontalAlignment(SwingConstants.LEFT);
        logsButton.setPreferredSize(savesButton.getPreferredSize());
        logsButton.addActionListener(_ -> Utils.openPath(Paths.get(Cogfly.localDataPath).resolve("logs")));

        JButton launchVanilla = new JButton("Launch Vanilla Game");
        launchVanilla.setHorizontalAlignment(SwingConstants.CENTER);
        launchVanilla.setPreferredSize(savesButton.getPreferredSize());
        launchVanilla.addActionListener(_ -> Cogfly.launchGameAsync(false, "", Cogfly.settings.gamePath));

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.X_AXIS));
        left.add(Box.createHorizontalStrut(300));
        left.add(savesButton);
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.X_AXIS));
        right.add(logsButton);
        right.add(Box.createHorizontalStrut(300));

        JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        center.add(launchVanilla);

        JPanel buttons = new JPanel(new BorderLayout());
        buttons.add(left, BorderLayout.WEST);
        buttons.add(center, BorderLayout.CENTER);
        buttons.add(right, BorderLayout.EAST);
        buttons.add(Box.createVerticalStrut(250), BorderLayout.SOUTH);
        return buttons;
    }
}
