/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly.instructions;

import be.belgiplast.quasar.assembly.Instruction;

/**
 *
 * @author T0194671
 */
public class Dconst1 extends Instruction{

    @Override
    public String getMnemonic() {
        return "dconst_1";
    }

    @Override
    public int getOpcode() {
        return 15;
    }
}
