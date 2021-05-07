package f03.plinko;

import java.util.HashMap;

/**
 *
 * @author Sollazzi
 */
public final class SettingsHolder {
    public static HashMap<String, Object> settings = new HashMap<>(); //Unused
    
    public static PlinkettoMode mode = PlinkettoMode.RANDOM;
            
    public enum PlinkettoMode {
        PHYSICS, RANDOM
    }
}
