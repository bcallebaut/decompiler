/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import java.io.DataInputStream;
import java.io.InputStream;

/**
 *
 * @author T0194671
 */
public abstract class Instruction {
    public abstract String getMnemonic();
    public abstract int getOpcode();
    
    public void decode(DataInputStream is){}
    
}
