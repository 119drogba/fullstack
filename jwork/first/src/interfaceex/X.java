package interfaceex;

public interface X {
	
	public abstract void xmeth1();
	public abstract void xmeth2();

}

interface Y {
	public abstract void ymeth1();
}

interface Z extends X,Y {
	 void zmeth1();
}