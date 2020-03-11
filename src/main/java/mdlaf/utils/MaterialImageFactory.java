/*
 * MIT License
 *
 * Copyright (c) 2018-2020 Vincenzo Palazzo vincenzopalazzodev@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.utils;

import jiconfont.IconCode;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import sun.swing.ImageIconUIResource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialImageFactory{

	//TODO start refactoring and import this library IconFontSwing
	static {
		IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
	}

	public static void registerIcons(IconCode iconCode){
		if(iconCode == null){
			String errorMessage = "\n- Icon code null you can found the name icon here: " +
					"https://jiconfont.github.io/\n" +
					"An example can be this IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());";
			throw new IllegalArgumentException(errorMessage);
		}
	}

	private static MaterialImageFactory SINGLETON;

	private static final String PATH_RESOUSES = "/imgs/";

	// blank image
	public static final String BLANK = "blank";

	//Icon black
	public static final String RIGHT_ARROW = "right_arrow";
	public static final String LEFT_ARROW = "left_arrow";
	public static final String DOWN_ARROW = "down_arrow";
	public static final String UP_ARROW = "up_arrow";
	public static final String CHECKED_BLACK_BOX = "painted_checked_box";
	public static final String UNCHECKED_BLACK_BOX = "unchecked_box";
	public static final String RADIO_BUTTON_BLACK_ON = "radio_button_on";
	public static final String RADIO_BUTTON_BLACK_OFF = "radio_button_off";
	public static final String TOGGLE_BUTTON_BLACK_ON = "toggle_on";
	public static final String TOGGLE_BUTTON_BLACK_OFF = "toggle_off";
	public static final String BACK_ARROW_BLACK = "back_arrow";
	public static final String COMPUTER_BLACK = "computer";
	public static final String FILE_BLACK = "file";
	public static final String FLOPPY_DRIVE_BLACK = "floppy_drive";
	public static final String FOLDER_BLACK = "folder";
	public static final String HARD_DRIVE_BLACK = "hard_drive";
	public static final String HOME_BLACK = "home";
	public static final String LIST_BLACK = "list";
	public static final String NEW_FOLDER_BLACK = "new_folder";
	public static final String DETAILS_BLACK = "details";
	public static final String YES_COLLAPSED = "yes-collapsed";
	public static final String NO_COLLAPSED = "no-collapsed";
	public static final String ERROR = "error";
	public static final String WARNING = "warning";
	public static final String QUESTION = "question";
	public static final String INFORMATION = "information";
	public static final String CLOSE_WINDOWS_BLACK = "close-button";
	public static final String MAXIMIZE_WINDOWS_BLACK = "maximize";
	public static final String MINIMIZE_WINDOWS_BLACK = "minimize";
	public static final String ICONIFY_WINDOWS_BLACK = "restore";

	//Icon White
	public static final String RADIO_BUTTON_WHITE_OFF = "white/radio_unchecked-white";
	public static final String CHECKED_WHITE_BOX = "white/checked_white";
	public static final String RADIO_BUTTON_WHITE_ON = "white/radio-checked-white";
	public static final String UNCHECKED_WHITE_BOX = "white/unchecked_white";
	public static final String BACK_ARROW_WHITE = "white/back_arrow";
	public static final String COMPUTER_WHITE = "white/computer";
	public static final String FILE_WHITE = "white/file";
	public static final String FLOPPY_DRIVE_WHITE = "white/floppy_drive";
	public static final String FOLDER_WHITE = "white/folder";
	public static final String HARD_DRIVE_WHITE = "white/hard_drive";
	public static final String HOME_WHITE = "white/home";
	public static final String LIST_WHITE = "white/list";
	public static final String NEW_FOLDER_WHITE = "white/new_folder";
	public static final String DETAILS_WHITE = "white/details";
	public static final String CLOSE_WINDOWS_WHITE = "white/close-button";
	public static final String MAXIMIZE_WINDOWS_WHITE = "white/maximize";
	public static final String MINIMIZE_WINDOWS_WHITE = "white/minimize";
	public static final String ICONIFY_WINDOWS_WHITE = "white/restore";
	public static final String TOGGLE_BUTTON_ON_WHITE = "white/toggle_on";
	public static final String TOGGLE_BUTTON_OFF_WHITE = "white/toggle_off";

	private Map<String, ImageIconUIResource> cacheImage = new HashMap<>();

	public static MaterialImageFactory getInstance() {
		if (SINGLETON == null) {
			SINGLETON = new MaterialImageFactory();
		}
		return SINGLETON;
	}

	private MaterialImageFactory() {
	}

	public ImageIconUIResource getImage(String key) {
		if (key == null) {
			throw new IllegalArgumentException("Argument null");
		}
		String path = PATH_RESOUSES.trim() + key.trim() + ".png".trim();
		if (cacheImage.containsKey(path)) {
			return cacheImage.get(path);
		}
		try (InputStream inputStream = MaterialImageFactory.class.getResourceAsStream(path)) {
			BufferedImage image = ImageIO.read(inputStream);
			cacheImage.put(path, new ImageIconUIResource(image));
			return cacheImage.get(path);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Image " + path + " wasn't loaded");
		}
	}

	/**
	 * This method utilized this library for make the icons https://jiconfont.github.io/swing
	 * by default the material-ui-swing utilized the Google font https://jiconfont.github.io/swing
	 * but you can set other type of font with method
	 * @param iconCode
	 * @param dimension: Is the dimension of icons, by default this library used dimension = 20
	 * @param color: Is the color of icons, by default this library used color = MaterialColors.BLACK;
	 * @return
	 */
	public ImageIconUIResource getImage(IconCode iconCode, int dimension, Color color){
		if(iconCode == null || dimension <= 0){
			String errorMessage = "Don't know motivation this exceptions";
			if(iconCode == null){
				if(errorMessage.contains("Don\'t know motivation this exceptions")){
					errorMessage = "";
				}
				errorMessage += "\n- Icon code null, you can found the name icon color here: " +
						"https://material.io/resources/icons/?style=baseline\n" +
						"an valid code can be this: " +
						"MaterialImageFactory.getInstance().getImage(" +
						"GoogleMaterialDesignIcons.KEYBOARD_ARROW_RIGHT, Color.BLUE);";
			}
			if(dimension <= 0){
				if(errorMessage.contains("Don\'t know motivation this exceptions")){
					errorMessage = "";
				}
				errorMessage += "\n- Dimension of icon doesn't valid, you should insert the dimension > 0";
			}
			errorMessage += "\n\n";
			throw new IllegalArgumentException(errorMessage);
		}
		String key;
		if(color == null){
			color = MaterialColors.BLACK;
		}
		key = iconCode.name() + dimension + color.toString();

		if(cacheImage.containsKey(key)){
			return cacheImage.get(key);
		}

		ImageIconUIResource icon = new ImageIconUIResource(IconFontSwing.buildImage(iconCode, dimension, color));
		cacheImage.put(key, icon);
		return icon;
	}

	public ImageIconUIResource getImage(IconCode iconCode, int dimension){
		return getImage(iconCode, dimension, null);
	}

	public ImageIconUIResource getImage(IconCode iconCode){
		return getImage(iconCode, 20, null);
	}

	public ImageIconUIResource getImage(IconCode iconCode, Color color){
		return getImage(iconCode, 20, color);
	}
}
