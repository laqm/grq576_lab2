/**
 * interface for creating vehicles with emergency support
 * @author grq576
 */

public interface EmergencySupport {
    /**
     * deploys relevant aid
     */
    public void deployAid();

    /**
     * returns a report with the vesicles emergency readiness
     * @return EmergencyReadinessReport
     */
    public String getEmergencyReadinessReport();
}
