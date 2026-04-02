package org.phprpc.util;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes2.dex */
public final class DHParams {
    private HashMap dhParams;
    private int length;
    private static final int[] lengths = {96, 128, 160, PsExtractor.AUDIO_STREAM, 256, 512, 768, 1024, 1536, 2048, 3072, 4096};
    private static final HashMap dhParamsGen = new HashMap();

    static {
        try {
            PHPSerializer pHPSerializer = new PHPSerializer();
            int length = lengths.length;
            for (int i = 0; i < length; i++) {
                dhParamsGen.put(new Integer(lengths[i]), (HashMap[]) pHPSerializer.unserialize(getBinaryFileFromJar("/dhparams/" + lengths[i] + ".dhp"), HashMap[].class));
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    private static byte[] getBinaryFileFromJar(String str) throws IOException {
        InputStream resourceAsStream = DHParams.class.getResourceAsStream(str);
        if (resourceAsStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = resourceAsStream.read(bArr);
            if (read >= 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static int getNearest(int i) {
        int i2 = 0;
        int abs = Math.abs(lengths[0] - i);
        for (int i3 = 1; i3 < lengths.length; i3++) {
            int abs2 = Math.abs(lengths[i3] - i);
            if (abs > abs2) {
                abs = abs2;
                i2 = i3;
            }
        }
        return lengths[i2];
    }

    public static HashMap getDHParams(int i) {
        HashMap[] hashMapArr = (HashMap[]) dhParamsGen.get(new Integer(i));
        return hashMapArr[(int) Math.floor(Math.random() * hashMapArr.length)];
    }

    public DHParams(int i) {
        this.length = getNearest(i);
        this.dhParams = getDHParams(this.length);
    }

    public int getL() {
        return this.length;
    }

    public BigInteger getP() {
        return new BigInteger(Cast.toString(this.dhParams.get(TtmlNode.TAG_P)));
    }

    public BigInteger getG() {
        return new BigInteger(Cast.toString(this.dhParams.get("g")));
    }

    public BigInteger getX() {
        return new BigInteger(this.length - 1, new Random()).setBit(this.length - 2);
    }

    public HashMap getDHParams() {
        return this.dhParams;
    }
}
