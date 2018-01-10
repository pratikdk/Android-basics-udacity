public class ReportCardTest {
	public static void main(String[] args) {
		ReportCard report1 = new ReportCard(2);
		report1.setSubEnglish(90, 80);
		report1.setSubHistory(50, 70);
		report1.setSubChemistry(40, 60);
		report1.setSubPhysics(80, 40);
		report1.setSubMaths(80, 70);
		System.out.println(report1.toString());
		// report1.printEnglishGrade();
		// int[] grades = report1.getSubEnglish();
		// for (int grade: grades) {
		// 	System.out.println(grade + "\n");
		// }


	}
}