/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import be.belgiplast.quasar.assembly.LowLevelClassFile.ConstantPool;

/**
 *
 * @author T0194671
 */
public abstract class ConstantPoolValue<T> {
    private ConstantPool cp;

    public ConstantPoolValue(ConstantPool cp) {
        this.cp = cp;
    }

    protected ConstantPool getCp() {
        return cp;
    }
    
    protected ConstantPoolValue get(int ref){
        return cp.get(ref - 1);
    }
    
    public abstract T getValue();
}
