import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinkedList {
	private Node top;
	private Node last;
	private int size;
	public LinkedList() {

	}
	public LinkedList(String str){
		 String line = null;
		 try {
		    	FileReader inputfile = new FileReader(str);
		    	BufferedReader buff = new BufferedReader(inputfile);
		    	while ((line = buff.readLine()) !=  null){
		    		String [] temp  = line.split("\\p{Space}+");
		    		for(int i = 0; i < temp.length;i++){
		    			append(temp[i]);
		    			size++;
		    		}
		    	}
		    	buff.close();
			} catch (IOException e) {
				System.out.println("no file found");
			}
	}
	public String format(int width){
		String result = "";
		Node temp = top;
		Node start = top;		
		String data;
		int count = 0;
		int lineCont =0;
		while(temp != null){
			data = temp.getData();
			if((count + (data).length()) < width){
				count += (data+" ").length();
			}
			else{
				Node start2 = start;
				if (lineCont %2== 0){
					while(start != temp){
						if(count <= width){
							start.setData(start.getData()+ " ");
							count++;
						}
						start =start.getLink();
					}
					while(start2.getLink() != temp){
						result += start2.getData()+" ";
						start2 =start2.getLink();
					}
					result += start2.getData();
				}
				else{
					int posCount = 0;
					String txt = "";
					int numLink = 0;
					while(start != temp){
						numLink++;
						start =start.getLink();
					}
					while(start2.getLink() != temp){
						txt += start2.getData()+" ";
						start2 =start2.getLink();
					}
					for(int i = 0; i < txt.length(); i++){
						if(txt.charAt(i)==' '){
							if( posCount>=numLink-1-width-1+count){
								result+=" ";
							}
							result+=" ";
							posCount++;
						}
						else{
							result+=txt.charAt(i);
						}
					}
					result += start2.getData();
					
				}
				
				result+="\n";
				lineCont ++;
				count = (data+" ").length();
			}
			if(temp.getLink() == null){
				while(start != null){
					result += start.getData()+" ";
					start =start.getLink();
				}
				result+="\n";
			}
			temp = temp.getLink();
		}
		return result;
	}
	public int size(){
		return size;
	}
	public void append(String text){
		Node temp = top;
		if (temp == null){
			Node newNode = new Node(text, null);
			top = newNode;
			last = newNode;
		}
		else{
			Node newNode = new Node(text, last.getLink());
			last.setLink(newNode);
			last = newNode;
		}
	}
}
class Node{
	private String data;
	private Node link;
	Node(String data,Node link){
		this.data = data;
		this.link = link;
	}
	public Node getLink(){
		return link;
	}
	public String getData(){
		return data;
	}
	public void setData(String str){
		this.data = str;
	}
	public void setLink(Node link){
		this.link = link;
	}
}
