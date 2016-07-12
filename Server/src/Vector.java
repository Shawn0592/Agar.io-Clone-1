public class Vector {
	
	public double th ;
	public double x,y;
	public double mag;
	public Vector normalized;
	
	private void calMag() {
		mag = Math.sqrt( (x)*(x) + (y)*(y) );
	}
	
	private void calTh() {
		th = Math.atan2(y, x);
	}
	
	private void calCartesian() {
		x =  (mag*Math.cos(th));
		y =  (mag*Math.sin(th));
	}
	
	public Vector(double dir ,double mag) {
		th = dir;
		this.mag = mag;
		calCartesian();
	}
	
	public Vector(Vector vec){	// copy ctor
		this(vec.th, vec.mag);
	}

	public Vector(double xi,double yi,double xf,double yf){
		x = xf-xi; y = yf-yi;
		calMag();
		calTh();
	}
	
	public void invert(){
		Scale(-1);
		calMag();
		calTh();
		Normalize();
	}

	private void Normalize(){
		calMag();
		normalized = new Vector(x/mag, y/mag);
	}

	public void Scale(double c){
		x = x*c;
		y = y*c;
		calMag();
		calTh();
	}
	
	public Vector getNormalized(){
		Normalize();
		return normalized;
	}
	
	public void add(double X, double Y){
		this.x += X;
		this.y += Y;
		
		calMag();
		calTh();
	}
	
}
