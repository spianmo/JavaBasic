package org.spianmo.algorithm.String;

import java.util.Arrays;

/**
 * @ClassName CustomizeString
 * @Description TODO
 * @Author Finger
 * @Date 10/13/2020
 **/
public class CustomizeString {
    final int MAXSIZE = 100;
    public char[] data;
    public int size;

    public CustomizeString() {
        data = new char[MAXSIZE];
        size = 0;
    }

    public CustomizeString(char[] data1) {
        data = new char[MAXSIZE];
        size = 0;
        this.data = data1;
    }

    public CustomizeString(char value[], int offset, int count) {
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count <= 0) {
            if (count < 0) {
                throw new StringIndexOutOfBoundsException(count);
            }
            if (offset <= value.length) {
                this.data = null;
                this.data = new char[MAXSIZE];
                return;
            }
        }
        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }
        this.data = Arrays.copyOfRange(value, offset, offset + count);
    }

    public CustomizeString SubStr(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > data.length) {
            throw new StringIndexOutOfBoundsException(endIndex);
        }
        int subLen = endIndex - beginIndex;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(subLen);
        }
        return ((beginIndex == 0) && (endIndex == data.length)) ? this : new CustomizeString(data, beginIndex, subLen);
    }

    public CustomizeString CommonSubStr(int beginIndex, int endIndex) {
        CustomizeString str = new CustomizeString();
        if (beginIndex < 0 || beginIndex >= size || endIndex < 0 || beginIndex + endIndex > size) {
            return str;
        }
        for (int k = beginIndex; k <= beginIndex + endIndex; k++) {
            str.data[k - beginIndex] = data[k];
        }
        str.size = endIndex;
        return str;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public String toFormatString() {
        StringBuilder sb = new StringBuilder();
        for (char c : data) {
            sb.append(c);
        }
        return sb.toString();
    }
}
