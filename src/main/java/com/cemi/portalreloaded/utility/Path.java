package com.cemi.portalreloaded.utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Path implements Serializable {
	private Queue<PathElement> currentPath = new LinkedList<PathElement>();

	private ArrayList<PathElement> path = new ArrayList<PathElement>();

	public Path() {
	}

	public void push(PathElement element) {
		path.add(element);
		resetQueue();
	}

	public PathElement pop() {
		return currentPath.remove();
	}

	public Queue<PathElement> getRemainingPathElements() {
		return currentPath;
	}

	public ArrayList<PathElement> getFullPath() {
		return path;
	}

	public void resetQueue() {
		currentPath = new LinkedList<>(path);
	}

	public void removeElementFromPath(int index) {
		path.remove(index);
		resetQueue();
	}

	public void insertElementToPath(PathElement element, int index) {
		path.add(index, element);
		resetQueue();
	}

	public PathElement skipTo(int index) {
		for (int i = 0; i < index-1; i++) {
			pop();
		}
		return currentPath.peek();
	}
	
	public boolean isFinished() {
		return currentPath.isEmpty();
	}
	
	public void clear() {
		path.clear();
		currentPath.clear();
	}

	public class PathElement implements Serializable {
		public double x, y, z, speed, waitTime;
		public float pitch, yaw;

		public PathElement(double x, double y, double z, double speed) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.speed = speed;
			waitTime = 0.0D;
		}

		public PathElement(double x, double y, double z, double speed, double waitTime) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.speed = speed;
			this.waitTime = waitTime;
		}

		public PathElement(double x, double y, double z, double speed, double waitTime, float pitch, float yaw) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.speed = speed;
			this.waitTime = waitTime;
			this.pitch = pitch;
			this.yaw = yaw;
		}
	}
}
