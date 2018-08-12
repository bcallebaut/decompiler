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
public class IInc extends Instruction{

    private int index;
    private int constant;
    
    public IInc(Code.InstructionCounter dis) throws IOException {
        super(dis);
        index = dis.readByte();
        constant = dis.readByte();
    }

    public int getIndex() {
        return index;
    }

    public int getConstant() {
        return constant;
    }

    @Override
    public String getMnemonic() {
        return "iinc";
    }

    @Override
    public int getOpcode() {
        return 132;
    }
    
    @Override
    protected String dumpParams() {
        return Integer.toString(index) +" " +Integer.toString(constant);
    }
}
