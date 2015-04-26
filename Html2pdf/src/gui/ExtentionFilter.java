/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Lorenz
 */
public class ExtentionFilter extends FileFilter{
    String extensie;
    
    public ExtentionFilter(String s){
        extensie=s;
    }

    @Override
    public boolean accept(File f) {
        return f.getPath().endsWith(extensie);
    }

    @Override
    public String getDescription() {
        return extensie+"-files";
    }
    
}
