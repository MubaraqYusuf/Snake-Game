/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author LENOVO
 */
import java.util.Iterator;
import java.util.LinkedList;

public class Setdifficulce {

	// this class creates the maps of the game
	
	int x, y;
	static boolean all[][];
	static LinkedList<Node> Walllist = new LinkedList<Node>();
	static int s = 0, s1 = 0;
	
	/* Get map choice: "1" for  normal, "3" for hard, "4" for hard2, "5" for hard 3
	 * There is no option Map.map == 2, because there aren't any walls in this case
	 */
	public static void checkmap() {
		if (Map.map == 1) {
			setnormal();
		} else if (Map.map == 3) {
			sethard();
		} else if (Map.map == 4) {
			sethard2();
		} 
		else if (Map.map == 5) {
			sethard3();
			
		} else {
			Node n;
			final LinkedList<Node> list1 = Setdifficulce.Walllist;
			final Iterator<Node> it1 = list1.iterator();
			while (it1.hasNext()) {
				n = it1.next();
				all[n.x][n.y] = false;
			}
			Walllist.clear();
		}

	}

	/* wallnum shows how many bricks has every wall
	 * wallamount shows the throng of walls
	 * if j equals to s, it will add horizontal walls
	 * if j equals to s1, it will add vertical walls
	 */
	public static void sethard() {
		setnormal();
		s = s1 = 0;
		for (int i = 0; i <= 24; i++) {
			s = 12 * i;
			s1 = 0;
			Walllist.addFirst(new Node(s, s1));
			all[s][s1] = true;
		}
		s = s1 = 0;
		for (int i = 0; i <= 24; i++) {
			s = 12 * i;
			s1 = 444;
			Walllist.addFirst(new Node(s, s1));
			all[s][s1] = true;
		}
		s = s1 = 0;
		for (int i = 1; i <= 36; i++) {
			s = 0;
			s1 = 12 * i;
			Walllist.addFirst(new Node(s, s1));
			all[s][s1] = true;
		}
		s = s1 = 0;
		for (int i = 1; i <= 36; i++) {
			s = 288;
			s1 = 12 * i;
			Walllist.addFirst(new Node(s, s1));
			all[s][s1] = true;
		}
	}

	public static void setnormal() {
		final LinkedList<Node> list = Walllist;
		final Iterator<Node> it = list.iterator();
		Node n1;
		while (it.hasNext()) {
			n1 = it.next();
			if ((n1.x == 192) && (n1.y == 288)) {
				break;
			} else {
				all[n1.x][n1.y] = false;
				it.remove();
			}
		}
		int wallnum, wallamount;
		wallnum = 9;
		wallamount = 5;
		for (int i = 0; i < wallamount; i++) {
			for (int j = 0; j < wallnum; j++) {
				switch (i) {
				case 0:
					s = 96 + 12 * j;
					s1 = 48;
					break;
				case 1:
					s = 96 + 12 * j;
					s1 = 408;
					break;
				case 2:
					s = 36;
					s1 = 180 + 12 * j;
					break;
				case 3:
					s = 252;
					s1 = 180 + 12 * j;
					break;
				case 4:
					s = 96 + 12 * j;
					s1 = 228;
					break;
				}
				Walllist.addFirst(new Node(s, s1));
				all[s][s1] = true;
			}
		}
	}
	
	//this method creates SSSuper Road
	public static void sethard3() {
		final LinkedList<Node> list = Walllist;
		final Iterator<Node> it = list.iterator();
		Node n1;
		while (it.hasNext()) {
			n1 = it.next();
			if ((n1.x == 192) && (n1.y == 288)) {
				break;
			} else {
				all[n1.x][n1.y] = false;
				it.remove();
			}
		}
		int wallnum, wallamount;
		wallnum = 16;
		wallamount = 14;
		for (int i = 0; i < wallamount; i++) {
			for (int j = 0; j < wallnum; j++) {
				switch (i) {
				case 0:
					s =96 + 12 * j;
					s1 = 36;
					break;
				case 1:
					s = 96 + 12 * j;
					s1 = 408;
					break;
				
				case 2:
					s = 36;
					s1 = 36+ 12 * j;
					break;
				case 3: 
					s =36 + 12 * j;
					s1 = 36;
					break;
				case 4:
					s =288;
					s1 =228+ 12 * j;
					break;
					
				case 5:
					s = 36 + 12 * j;
					s1 = 408;
					break;
				case 6:
					s =96 + 12 * j;
					s1 =228;
					break;
				case 7:
					s =36+ 12 * j;
					s1 =228;
					break;
				case 8:
					s =72+ 12 * j;
					s1 =300;
					break;
				
				case 9:
					s =72+ 12 * j;
					s1 =324;
					break;
				
			   case 10:
				   s =72+ 12 * j;
				   s1 =312;
				break;
				case 11:
					s =72+ 12 * j;
					s1 =132;
					break;
				
				case 12:
					s =72+ 12 * j;
					s1 =144;
					break;
				
				 case 13:
					   s =72+ 12 * j;
					   s1 =120;
					break;
	
				
			}
				Walllist.addFirst(new Node(s, s1));
				all[s][s1] = true;
			}
		}
	
	}
	
	// this method creates Round & Round
	public static void sethard2() {
		final LinkedList<Node> list = Walllist;
		final Iterator<Node> it = list.iterator();
		Node n1;
		while (it.hasNext()) {
			n1 = it.next();
			if ((n1.x == 192) && (n1.y == 288)) {
				break;
			} else {
				all[n1.x][n1.y] = false;
				it.remove();
			}
		}
		int wallnum, wallamount;
		wallnum = 13;
		wallamount = 14;
		for (int i = 0; i < wallamount; i++) {
			for (int j = 0; j < wallnum; j++) {
				switch (i) {
				case 0:
					s =96 + 12 * j;
					s1 = 36;
					break;
				case 1:
					s =48+ 12 * j;
					s1 = 408;
					break;
				case 2:
					s = 36;
					s1 = 192 + 12 * j;
					break;
				case 3:
					s = 252;
					s1 = 108 + 12 * j;
					break;
				case 4:
					s = 36;
					s1 = 36+ 12 * j;
					break;
				case 5:
					s =36 + 12 * j;
					s1 = 36;
					break;
				case 6:
					s =252;
					s1 =252+ 12 * j;
					break;
				case 7:
					s =108 + 12 * j;
					s1 = 408;
					break;
				case 8:
					s =72 + 12 * j;
					s1 = 360;
					break;
				case 9:
					s =72 + 12 * j;
					s1 =84;
					break;
				case 10:
					s =216;
					s1 =84+ 12 * j;
					break;
				case 11:
					s =216;
					s1 =144+ 12 * j;
					break;
				case 12:
					s =72;
					s1 =204+ 12 * j;
					break;
				case 13:
					s =72;
					s1 =156+ 12 * j;
					break;
				}
				Walllist.addFirst(new Node(s, s1));
				all[s][s1] = true;
			}
		}
	
	}
	
	//set the panel size
	public Setdifficulce() {
		all = new boolean[289][445];
		for (int i = 0; i < 288; ++i) {
			for (int j = 0; j < 444; ++j) {
				all[i][j] = false;
			}
		}
	}
}

