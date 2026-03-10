/**
 * interface for creating vehicles that can navigate
 * @author grq576
 */

public interface Navigable {
    /**
     * navigates vesicle to specified destination
     * @param destination
     */
    public void navigateTo(String destination);

    /**
     * sets the speed of the vesicle
     * @param speed
     */
    public void setCurrentSpeed(double speed);

    /**
     * gets the speed of the vesicle
     */
    public double getCurrentSpeed();
}
