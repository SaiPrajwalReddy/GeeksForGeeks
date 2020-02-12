package StackAndQueue;

public class CircularTour {

	static class petrolPump {

		public petrolPump(int i, int j) {
			petrol = i;
			distance = j;
			// TODO Auto-generated constructor stub
		}

		int petrol;
		int distance;

	}

	public static void main(String args[]) {
		petrolPump[] arr = { new petrolPump(6, 4), new petrolPump(3, 6), new petrolPump(7, 3) };
		int start = printTour(arr, arr.length);
		System.out.println("Starting Index is " + start);
	}

	private static int printTour(petrolPump[] arr, int length) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = 1;
		int currentPetrol = 0;

		currentPetrol = arr[start].petrol - (arr[start].distance);

		while (end != start || currentPetrol < 0) {
			while (end != start && currentPetrol < 0) {
				currentPetrol -= arr[start].petrol - arr[start].distance;
				start = (start + 1) % arr.length;

				if (start == 0)
					return -1;
			}
			currentPetrol += arr[end].petrol - arr[end].distance;

			end = (end + 1) % arr.length;
		}

		return start;
	}
}
