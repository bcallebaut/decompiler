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
public class AStore extends Instruction{

    int index;
    
    public AStore(Code.InstructionCounter dis) throws IOException {
        super(dis);
        index = dis.readByte();
    }

    @Override
    public String getMnemonic() {
        return "astore";
    }

    @Override
    public int getOpcode() {
        return 59;
    }
    
    @Override
    protected String dumpParams() {
        return Integer.toString(index);
    }
}
