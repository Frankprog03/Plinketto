package f03.plinko;

import f03.plinko.gui.MainJFrame;

/**
 *
 * @author Sollazzi
 */
public final class SettingsHolder {
    public static PlinkettoMode mode = PlinkettoMode.RANDOM;
    
    public static MainJFrame mainFrame = null;
            
    public enum PlinkettoMode {
        PHYSICS, RANDOM
    }
}
