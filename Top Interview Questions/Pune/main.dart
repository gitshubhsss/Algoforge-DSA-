main() {}

List<int> removeDuplicates(List<int> list) {
  var seen = <int>{};
  var duplicates = <int>{};

  for (var item in list) {
    if (seen.add(item) == false) {
      duplicates.add(item);
    }
  }

  return duplicates.toList();
}
