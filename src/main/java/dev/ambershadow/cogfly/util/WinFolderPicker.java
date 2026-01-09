package dev.ambershadow.cogfly.util;

import com.sun.jna.Library;
import com.sun.jna.WString;

public interface WinFolderPicker extends Library {
    WString pickFolder();
}
