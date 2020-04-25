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
package integration.gui.mock.component;


import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class TableModelSecondPanel extends AbstractTableModel {

    protected File dir;
    protected String[] filenames;

    protected String[] columnNames = new String[] {
            "name", "size", "last modified", "directory?", "readable?", "writable?"
    };

    protected Class[] columnClasses = new Class[] {
            String.class, Long.class, Date.class,
            Boolean.class, Boolean.class, Boolean.class
    };

    // This table model works for any one given directory
    public TableModelSecondPanel(File dir) {
        this.dir = dir;
        this.filenames = dir.list();  // Store a list of files in the directory
    }

    // These are easy methods
    public int getColumnCount() { return 6; }  // A constant for this model
    public int getRowCount() { return filenames.length; }  // # of files in dir

    // Information about each column
    public String getColumnName(int col) { return columnNames[col]; }
    public Class getColumnClass(int col) { return columnClasses[col]; }

    // The method that must actually return the value of each cell
    public Object getValueAt(int row, int col) {
        File f = new File(dir, filenames[row]);
        switch(col) {
            case 0: return filenames[row];
            case 1: return new Long(f.length());
            case 2: return new Date(f.lastModified());
            case 3: return f.isDirectory() ? Boolean.TRUE : Boolean.FALSE;
            case 4: return f.canRead() ? Boolean.TRUE : Boolean.FALSE;
            case 5: return f.canWrite() ? Boolean.TRUE : Boolean.FALSE;
            default: return null;
        }
    }
}

