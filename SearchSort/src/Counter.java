
public class Counter {
	private int value;
	
	public Counter(int value) {
	   this.value = value;
	}
	
	public void incr() {
	   this.value++;
	}
	
	public boolean equals(Object obj) {
	   if (this == obj) {
		 return true;
	   }
	   if (!(obj instanceof Counter)) {
		 return false;
	   }
	   Counter other = (Counter) obj;
	   return this.value == other.value;
	}
	
	public String toString() {
	   return String.valueOf(value);
	}
	
	public static void crazy1(Counter int1, Counter int2) {
		
		int1 = int2;
		int2 = int1;
		int1.incr();
		int2.incr();
	
		
	}
	
	public static void crazy2(Counter int1, Counter int2) {
		
		int1.incr();
		int2 = new Counter(30);
		int2.incr();
		
	}
	
	public static void main (String[] args) {
		
		Counter[] aryA = {new Counter(15), new Counter(5), new Counter(10)};
		Counter[] aryB = {new Counter(3), null, null};
		Counter[] aryC = aryA;
		
		System.out.println(aryA[0] + " " + aryA[1] + " " + aryA[2]);
		System.out.println(aryB[0] + " " + aryB[1] + " " + aryB[2]);
		System.out.println(aryC[0] + " " + aryC[1] + " " + aryC[2]);
		
		for (int i = 0; i < aryA.length; i++) {
			
			aryA[i].incr();
			aryB[i] = new Counter(Integer.parseInt(aryA[i].toString()));
			aryC[i].incr();
			
		}
		
		System.out.println(aryA[0] + " " + aryA[1] + " " + aryA[2]);
		System.out.println(aryB[0] + " " + aryB[1] + " " + aryB[2]);
		System.out.println(aryC[0] + " " + aryC[1] + " " + aryC[2]);
		
		
		Counter int1 = new Counter(20);
		Counter int2 = new Counter(40);
		System.out.println(int1 + " " + int2);
		crazy1(int1, int2);
		System.out.println(int1 + " " + int2);
		crazy1(int2, int1);
		System.out.println(int1 + " " + int2);
		crazy2(int1, int2);
		System.out.println(int1 + " " + int2);
		crazy2(int2, int1);
		System.out.println(int1 + " " + int2);
		
		
		
	}
}

