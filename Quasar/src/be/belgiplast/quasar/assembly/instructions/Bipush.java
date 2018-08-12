/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly.instructions;

import java.io.IOException;
import be.belgiplast.quasar.assembly.Code;
import be.belgiplast.quasar.assembly.Instruction;

/**
 *
 * @author T0194671
 */
public class Bipush extends Instruction{

    int value;
    
    public Bipush(Code.InstructionCounter dis) throws IOException {
        super(dis);
        value = dis.readByte();
    }

    public int getValue() {
        return value;
    }

    @Override
    public String getMnemonic() {
        return "bipush";
    }

    @Override
    public int getOpcode() {
        return 16;
    }
    
    @Override
    protected String dumpParams() {
        return Integer.toString(value);
    }
}
