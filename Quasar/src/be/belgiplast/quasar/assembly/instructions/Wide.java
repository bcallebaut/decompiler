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
public class Wide extends Instruction{

    private int index;
    private int constant = 0;
    
    public Wide(Code.InstructionCounter dis) throws IOException {
        super(dis);
        int  mod  = dis.readByte();
        index = dis.readByte() << 8 | dis.readByte();
        if (mod == 132){
            constant = dis.readByte() << 8 | dis.readByte();
        }
    }

    public int getIndex() {
        return index;
    }

    public int getConstant() {
        return constant;
    }

    @Override
    public String getMnemonic() {
        return "wide";
    }

    @Override
    public int getOpcode() {
        return 196;
    }
}
