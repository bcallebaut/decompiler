/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import java.io.DataInputStream;
import be.belgiplast.quasar.assembly.Code.InstructionCounter;

/**
 *
 * @author T0194671
 */
public abstract class Instruction {
    
    private final int instructionIndex;
    public Instruction(InstructionCounter dis){
        instructionIndex = dis.getCounter() - 1;
    }

    public final int getInstructionIndex() {
        return instructionIndex;
    }
    
    protected String dumpParams(){
        return "";
    }
    
    public abstract String getMnemonic();
    public abstract int getOpcode();
    public void dump(){
        String params = dumpParams();
        params = params.length() > 0 ? "#"+params: params;
        System.out.println(String.format("   %d : %s %s",getInstructionIndex() ,getMnemonic(),params));
    }
    
    public void decode(DataInputStream is){}
    
}
