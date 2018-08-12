/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import java.io.DataInputStream;
import java.io.InputStream;
import be.belgiplast.quasar.assembly.LowLevelClassFile.ConstantPool;

/**
 *
 * @author T0194671
 */
public class ExceptionBlock {
    Instruction start;
    Instruction end;
    Instruction handler;
    String catchType;

    public ExceptionBlock(Code code,InputStream is){
        DataInputStream dis = new DataInputStream(is);
        
    }
    
    public Instruction getStart() {
        return start;
    }

    public Instruction getEnd() {
        return end;
    }

    public Instruction getHandler() {
        return handler;
    }

    public String getCatchType() {
        return catchType;
    }
}
