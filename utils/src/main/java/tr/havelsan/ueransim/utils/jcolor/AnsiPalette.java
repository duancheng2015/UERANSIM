/*
 * MIT License
 *
 * Copyright (c) 2020 ALİ GÜNGÖR
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

package tr.havelsan.ueransim.utils.jcolor;

public class AnsiPalette {

    public static final AnsiColorFormat PAINT_LOG_NORMAL = new AnsiColorFormat(AnsiColorAttribute.BRIGHT_WHITE_TEXT());
    public static final AnsiColorFormat PAINT_LOG_SUCCESS = new AnsiColorFormat(AnsiColorAttribute.BRIGHT_GREEN_TEXT(), AnsiColorAttribute.BOLD());
    public static final AnsiColorFormat PAINT_LOG_WARNING = new AnsiColorFormat(AnsiColorAttribute.BRIGHT_YELLOW_TEXT(), AnsiColorAttribute.BOLD());
    public static final AnsiColorFormat PAINT_LOG_ERROR = new AnsiColorFormat(AnsiColorAttribute.BRIGHT_RED_TEXT(), AnsiColorAttribute.BOLD());

    public static final AnsiColorFormat PAINT_IMPORTANT_INFO = new AnsiColorFormat(AnsiColorAttribute.BRIGHT_BLUE_TEXT(), AnsiColorAttribute.BOLD());
    public static final AnsiColorFormat PAINT_IMPORTANT_WARNING = new AnsiColorFormat(AnsiColorAttribute.BRIGHT_YELLOW_TEXT(), AnsiColorAttribute.BOLD());

    public static final AnsiColorFormat PAINT_DIVIDER = new AnsiColorFormat(AnsiColorAttribute.BRIGHT_BLUE_TEXT(), AnsiColorAttribute.BOLD());
    public static final AnsiColorFormat PAINT_INPUT = new AnsiColorFormat(AnsiColorAttribute.BRIGHT_BLUE_TEXT(), AnsiColorAttribute.BOLD());

}
