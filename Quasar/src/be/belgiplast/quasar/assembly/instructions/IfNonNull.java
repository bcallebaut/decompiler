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
public class IfNonNull extends Instruction{

    private int index;
    
    public IfNonNull(Code.InstructionCounter dis) throws IOException {
        super(dis);
        index = dis.readByte() << 8 | dis.readByte();
    }

    public int getBranch() {
        return index;
    }

    @Override
    public String getMnemonic() {
        return "ifnonnull";
    }

    @Override
    public int getOpcode() {
        return 199;
    }
    
    @Override
    protected String dumpParams() {
        return Integer.toString(index);
    }
}