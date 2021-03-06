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
public class IfNull extends Instruction{

    private int index;
    
    public IfNull(Code.InstructionCounter dis) throws IOException {
        super(dis);
        index = dis.readByte() << 8 | dis.readByte();
    }

    @Override
    public String getMnemonic() {
        return "ifnull";
    }

    @Override
    public int getOpcode() {
        return 198;
    }
    
    @Override
    protected String dumpParams() {
        return Integer.toString(index);
    }
}
