/*
 * MIT License
 *
 * Copyright (c) 2019-2020 Vincenzo Palazzo vincenzopalazzo1996@gmail.com
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
package integration.gui.test;

import javax.swing.*;
import org.assertj.swing.fixture.JButtonFixture;
import org.junit.Test;

/** @author https://github.com/vincenzopalazzo */
public class MaterialFocusedButtonTest extends AbstractTestGUI {

  @Override
  protected void onBeforeGuiSetUp() {
    UIManager.put("Button.mouseHoverEnable", false);
  }

  @Override
  protected void onTearDown() {
    UIManager.put("Button.mouseHoverEnable", true);
  }

  @Test
  public void testButtonNormalColorBackgroundWhenIsFocused() {
    JButtonFixture buttonUndo = frame.button("buttonNormal");
    buttonUndo.background().requireEqualTo(theme.getButtonBackgroundColor());
    buttonUndo.foreground().requireEqualTo(theme.getButtonTextColor());
    buttonUndo.focus();
    buttonUndo.background().requireEqualTo(theme.getButtonBackgroundColor());
    buttonUndo.foreground().requireEqualTo(theme.getButtonTextColor());
  }

  @Test
  public void testButtonColorBackgroundDefaultWhenIsFocused() {
    JButtonFixture buttonDefault = frame.button("buttonDefault");
    buttonDefault.background().requireEqualTo(theme.getButtonDefaultBackgroundColor());
    buttonDefault.foreground().requireEqualTo(theme.getButtonDefaultTextColor());
    buttonDefault.focus();
    buttonDefault.background().requireEqualTo(theme.getButtonDefaultBackgroundColor());
    buttonDefault.foreground().requireEqualTo(theme.getButtonDefaultTextColor());
  }
}
