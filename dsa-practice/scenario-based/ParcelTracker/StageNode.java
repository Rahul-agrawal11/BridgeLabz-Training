package scenario.ParcelTracker;

class StageNode {
    String stageName;
    StageNode next;

    public StageNode(String stageName) {
        this.stageName = stageName;
        this.next = null;
    }
}
