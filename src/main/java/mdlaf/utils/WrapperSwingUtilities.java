/*
 * MIT License
 *
 * Copyright (c) 2020 Vincenzo Palazzo vincenzopalazzodev@gmail.com
 * Copyright (c) 2021 Vincenzo Palazzo vincenzopalazzodev@gmail.com
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

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class WrapperSwingUtilities {

    private static WrapperSwingUtilities SINGLETON;

    public static WrapperSwingUtilities getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new WrapperSwingUtilities();
        }
        return SINGLETON;
    }

    protected Class wrapperClass;
    protected Method getClippedString;

    private WrapperSwingUtilities() {
        this.initMethodWithJavaVersion();
    }

    public void initMethodWithJavaVersion() {
        try {
            if (Utils.isJavaVersionUnderJava9()) {
                //I can load the method in Swing sun.swing.SwingUtilities2
                this.wrapperClass = Class.forName("sun.swing.SwingUtilities2");
                getClippedString = this.wrapperClass.getMethod("clipStringIfNecessary",
                               new Class[]{ JComponent.class, FontMetrics.class, String.class, int.class});
            }else{
                //I can load method from class javax.swing.plaf.basic.BasicGraphicsUtils
                this.wrapperClass = Class.forName("javax.swing.plaf.basic.BasicGraphicsUtils");
                getClippedString = this.wrapperClass.getMethod("getClippedString",
                        new Class[]{ JComponent.class, FontMetrics.class, String.class, int.class});
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getCause());
        }
    }

    public String getClippedString(JComponent component, FontMetrics fontMetrics, String text, int availTextWidth){
        try {
            return (String) getClippedString.invoke(wrapperClass, component, fontMetrics, text, availTextWidth);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getCause());
        }
    }

}
