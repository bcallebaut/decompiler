/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly.instructions;

import java.io.DataInputStream;
import be.belgiplast.quasar.assembly.Code.InstructionCounter;
import be.belgiplast.quasar.assembly.Instruction;

/**
 *
 * @author T0194671
 */
public class AALoad extends Instruction{

    public AALoad(InstructionCounter dis) {
        super(dis);
        
    }
    
    @Override
    public String getMnemonic() {
        return "aaload";
    }

    @Override
    public int getOpcode() {
        return 50;
    }
    
    
}
