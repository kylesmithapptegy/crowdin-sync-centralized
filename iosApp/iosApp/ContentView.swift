import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
		Text(Strings().get(id: SharedRes.strings().hello_world, args: []))
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}