package task1631;


/* 
Factory method pattern
1. ����������� ��������, ����� ������ � ���� ����.
2. � ��������� ������ � ������ common ������ ������ JpgReader, PngReader, BmpReader, ������� ��������� ��������� ImageReader.
3. � ��������� ����� � �������� ������ ������ ����� ImageReaderFactory � ����� �������.
3.1. �������, ��� �� ������ ����������.
3.2. �������, ����� ������������ ������ ���� � ����� ������.
4. ���� ����� ������:
4.1. ��� ������� �������� �� ImageTypes ���������� ��������������� Reader, ��������, ��� ImageTypes.JPG - JpgReader;
4.2. ���� ������� ������������ �������� (� �.�. null), �� ����������� ���������� IllegalArgumentException("����������� ��� ��������").


Requirements:
1. ������ � ������ common ����� JpgReader, ����������� ��������� ImageReader.
2. ������ � ������ common ����� PngReader, ����������� ��������� ImageReader.
3. ������ � ������ common ����� BmpReader, ����������� ��������� ImageReader.
4. ������ ��������� ����� ImageReaderFactory.
5. ������ � ����� ImageReaderFactory �������� ����������� ����� getImageReader � ���������� ImageTypes.
6. ����� getImageReader ������ ��������� � ���������� ���������� Reader.
7. ����� getImageReader ������ ������ ���������� IllegalArgumentException, ���� ������� ������������ ��������.*/

import task1631.common.ImageReader;
import task1631.common.ImageTypes;
import task1631.common.JpgReader;

public class Solution {
    public static void main(String[] args) throws IllegalArgumentException {
               ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
               System.out.println(reader.getClass());
    }
}
