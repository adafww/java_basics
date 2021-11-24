public class ArrayVoterCounts {
    private VoterCounts[] voterCounts;
    int count = 0;

    public VoterCounts[] getVoterCounts() {
        return voterCounts;
    }

    public void setVoterCounts(VoterCounts voterCounts) {
        
        this.voterCounts[0] = voterCounts;
        count++;
    }
}
