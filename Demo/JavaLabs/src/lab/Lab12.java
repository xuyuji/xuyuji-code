package lab;

public class Lab12 {
	public static void main(String[] args) {
		System.out.println("a ascii code:" + Integer.toBinaryString('a'));
		System.out.println("A ascii code:" + Integer.toBinaryString('A'));
		System.out.println("b ascii code:" + Integer.toBinaryString('b'));
		System.out.println("B ascii code:" + Integer.toBinaryString('B'));
		System.out.println(new Lab12().change("LJJALdlkskflKFklfKldfKLFJD"));
	}
	/**
	 * 大小写反置
	 * @param oldStr
	 * @return
	 */
	public String change(String oldStr){
		char[] oldArray = oldStr.toCharArray();
		char[] newArray = new char[oldArray.length];
		for(int i = 0; i < oldArray.length; i++){
			//英文大小写在ASCII码中是通过第六位区分的
			newArray[i] = (char) (oldArray[i] ^ 0x20);
		}
		return new String(newArray);
	}
}
