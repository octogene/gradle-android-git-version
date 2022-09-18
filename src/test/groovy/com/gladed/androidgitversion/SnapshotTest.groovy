package com.gladed.androidgitversion

class SnapshotTest extends AndroidGitVersionTest {
    void testDefaultPatchIncrementSnapshot() {
        addCommit()
        addTag("1.2.0")
        addCommit()
        plugin.autoSnapshot = true
        assertEquals("1.2.1-SNAPSHOT", plugin.name())
    }

    void testMinorIncrementSnapshot() {
        addCommit()
        addTag("1.2.1")
        addCommit()
        plugin.autoSnapshot = true
        plugin.snapshotIncrementOn = 'N'
        assertEquals("1.3.0-SNAPSHOT", plugin.name())
    }

    void testMajorIncrementSnapshot() {
        addCommit()
        addTag("1.2.0")
        addCommit()
        plugin.autoSnapshot = true
        plugin.snapshotIncrementOn = 'M'
        assertEquals("2.0.0-SNAPSHOT", plugin.name())
    }

    void testDefaultMajorIncrementSnapshotWithCount() {
        addCommit()
        addTag("1.2.0")
        addCommit()
        plugin.autoSnapshot = true
        plugin.snapshotFormat = "%tag%-SNAPSHOT%count%"
        assertEquals("1.2.1-SNAPSHOT1", plugin.name())
    }
}
