/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly.instructions;

import be.belgiplast.quasar.assembly.Code;
import be.belgiplast.quasar.assembly.Instruction;

/**
 *
 * @author T0194671
 */
public class DAdd extends Instruction{

    public DAdd(Code.InstructionCounter dis) {
        super(dis);
    }

    @Override
    public String getMnemonic() {
        return "dadd";
    }

    @Override
    public int getOpcode() {
        return 99;
    }
}
