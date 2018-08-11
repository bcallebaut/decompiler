/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

/**
 *
 * @author T0194671
 */
public enum ClassVersionEnum {
    JDK_1_0_2(45,3),
    JDK_1_1(45,0),
    JDK1_2(46,0),
    JDK1_3(47,0),
    JDK1_4(48,0),
    JDK5(49,0),
    JDK6(50,0),
    JDK7(51,0),
    JDK8(52,0),
    JDK9(53,0),
    JDK10(54,0);
    
    private int major;
    private int minor;

    private ClassVersionEnum(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }
    
    public static ClassVersionEnum version(int major,int minor){
        switch (major){
            case 45:
                switch (minor){
                    case 3: return JDK_1_0_2;
                    default : return JDK_1_1;
                }
            case 46: return JDK1_2;    
            case 47: return JDK1_3;
            case 48: return JDK1_4;
            case 49: return JDK5;
            case 50: return JDK6;
            case 51: return JDK7;
            case 52: return JDK8;
            case 53: return JDK9;
            case 54: return JDK10;            
        }
        return JDK_1_0_2;
    }
}
