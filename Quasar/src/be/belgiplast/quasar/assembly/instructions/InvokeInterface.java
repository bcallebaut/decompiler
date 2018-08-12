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
public class InvokeInterface extends Instruction{

    private int index;
    private int count;
    
    public InvokeInterface(Code.InstructionCounter dis) throws IOException {
        super(dis);
        index = dis.readByte() << 8 | dis.readByte();
        count = dis.readByte();
        dis.readByte();
    }

    public int getIndex() {
        return index;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String getMnemonic() {
        return "invokeInterface";
    }

    @Override
    public int getOpcode() {
        return 185;
    }
    
    @Override
    protected String dumpParams() {
        return Integer.toString(index) +" " + Integer.toString(count);
    }
}
