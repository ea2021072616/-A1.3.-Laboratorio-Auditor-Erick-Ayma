package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class DefaultAllocator implements Allocator {
    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private Allocation[] availableAllocations;
    private int availableCount;
    private final int individualAllocationSize;
    private final byte[] initialAllocationBlock;
    private final Allocation[] singleAllocationReleaseHolder;
    private int targetBufferSize;
    private final boolean trimOnReset;

    public DefaultAllocator(boolean z, int i) {
        this(z, i, 0);
    }

    public DefaultAllocator(boolean z, int i, int i2) {
        Assertions.checkArgument(i > 0);
        Assertions.checkArgument(i2 >= 0);
        this.trimOnReset = z;
        this.individualAllocationSize = i;
        this.availableCount = i2;
        this.availableAllocations = new Allocation[i2 + 100];
        if (i2 > 0) {
            this.initialAllocationBlock = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.availableAllocations[i3] = new Allocation(this.initialAllocationBlock, i3 * i);
            }
        } else {
            this.initialAllocationBlock = null;
        }
        this.singleAllocationReleaseHolder = new Allocation[1];
    }

    public synchronized void reset() {
        if (this.trimOnReset) {
            setTargetBufferSize(0);
        }
    }

    public synchronized void setTargetBufferSize(int i) {
        boolean z = i < this.targetBufferSize;
        this.targetBufferSize = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized Allocation allocate() {
        Allocation allocation;
        this.allocatedCount++;
        if (this.availableCount > 0) {
            Allocation[] allocationArr = this.availableAllocations;
            int i = this.availableCount - 1;
            this.availableCount = i;
            allocation = allocationArr[i];
            this.availableAllocations[this.availableCount] = null;
        } else {
            allocation = new Allocation(new byte[this.individualAllocationSize], 0);
        }
        return allocation;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation allocation) {
        this.singleAllocationReleaseHolder[0] = allocation;
        release(this.singleAllocationReleaseHolder);
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation[] allocationArr) {
        if (this.availableCount + allocationArr.length >= this.availableAllocations.length) {
            this.availableAllocations = (Allocation[]) Arrays.copyOf(this.availableAllocations, Math.max(this.availableAllocations.length * 2, this.availableCount + allocationArr.length));
        }
        for (Allocation allocation : allocationArr) {
            Assertions.checkArgument(allocation.data == this.initialAllocationBlock || allocation.data.length == this.individualAllocationSize);
            Allocation[] allocationArr2 = this.availableAllocations;
            int i = this.availableCount;
            this.availableCount = i + 1;
            allocationArr2[i] = allocation;
        }
        this.allocatedCount -= allocationArr.length;
        notifyAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 < r7.availableCount) goto L31;
     */
    @Override // com.google.android.exoplayer2.upstream.Allocator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void trim() {
        /*
            r7 = this;
            r1 = 0
            monitor-enter(r7)
            int r0 = r7.targetBufferSize     // Catch: java.lang.Throwable -> L5e
            int r2 = r7.individualAllocationSize     // Catch: java.lang.Throwable -> L5e
            int r0 = com.google.android.exoplayer2.util.Util.ceilDivide(r0, r2)     // Catch: java.lang.Throwable -> L5e
            r2 = 0
            int r3 = r7.allocatedCount     // Catch: java.lang.Throwable -> L5e
            int r0 = r0 - r3
            int r3 = java.lang.Math.max(r2, r0)     // Catch: java.lang.Throwable -> L5e
            int r0 = r7.availableCount     // Catch: java.lang.Throwable -> L5e
            if (r3 < r0) goto L18
        L16:
            monitor-exit(r7)
            return
        L18:
            byte[] r0 = r7.initialAllocationBlock     // Catch: java.lang.Throwable -> L5e
            if (r0 == 0) goto L61
            int r0 = r7.availableCount     // Catch: java.lang.Throwable -> L5e
            int r0 = r0 + (-1)
        L20:
            if (r1 > r0) goto L4b
            com.google.android.exoplayer2.upstream.Allocation[] r2 = r7.availableAllocations     // Catch: java.lang.Throwable -> L5e
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L5e
            byte[] r2 = r4.data     // Catch: java.lang.Throwable -> L5e
            byte[] r5 = r7.initialAllocationBlock     // Catch: java.lang.Throwable -> L5e
            if (r2 != r5) goto L2f
            int r1 = r1 + 1
            goto L20
        L2f:
            com.google.android.exoplayer2.upstream.Allocation[] r2 = r7.availableAllocations     // Catch: java.lang.Throwable -> L5e
            r5 = r2[r0]     // Catch: java.lang.Throwable -> L5e
            byte[] r2 = r5.data     // Catch: java.lang.Throwable -> L5e
            byte[] r6 = r7.initialAllocationBlock     // Catch: java.lang.Throwable -> L5e
            if (r2 == r6) goto L3c
            int r0 = r0 + (-1)
            goto L20
        L3c:
            com.google.android.exoplayer2.upstream.Allocation[] r6 = r7.availableAllocations     // Catch: java.lang.Throwable -> L5e
            int r2 = r1 + 1
            r6[r1] = r5     // Catch: java.lang.Throwable -> L5e
            com.google.android.exoplayer2.upstream.Allocation[] r5 = r7.availableAllocations     // Catch: java.lang.Throwable -> L5e
            int r1 = r0 + (-1)
            r5[r0] = r4     // Catch: java.lang.Throwable -> L5e
            r0 = r1
            r1 = r2
            goto L20
        L4b:
            int r0 = java.lang.Math.max(r3, r1)     // Catch: java.lang.Throwable -> L5e
            int r1 = r7.availableCount     // Catch: java.lang.Throwable -> L5e
            if (r0 >= r1) goto L16
        L53:
            com.google.android.exoplayer2.upstream.Allocation[] r1 = r7.availableAllocations     // Catch: java.lang.Throwable -> L5e
            int r2 = r7.availableCount     // Catch: java.lang.Throwable -> L5e
            r3 = 0
            java.util.Arrays.fill(r1, r0, r2, r3)     // Catch: java.lang.Throwable -> L5e
            r7.availableCount = r0     // Catch: java.lang.Throwable -> L5e
            goto L16
        L5e:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        L61:
            r0 = r3
            goto L53
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.DefaultAllocator.trim():void");
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized int getTotalBytesAllocated() {
        return this.allocatedCount * this.individualAllocationSize;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public int getIndividualAllocationLength() {
        return this.individualAllocationSize;
    }
}
