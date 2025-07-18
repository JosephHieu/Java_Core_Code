package PhoneAndEmailContact;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phonecContacts = new HashSet<>(phones);
        printData("Phone Contacts", phonecContacts);
        printData("Email Contacts", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com",
                "RHood@sherwoodforest.org");
        System.out.println(robinHood);

        System.out.println("---".repeat(15));
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phonecContacts);
        printData("(A ∪ B) Union of emails (A) with phones (B)", unionAB);

        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phonecContacts);
        printData("(A ∩ B) Intersect emails (A) and phones (B)",
                intersectAB);

        Set<Contact> intersectBA = new HashSet<>(phonecContacts);
        intersectBA.retainAll(emailContacts);
        printData("(B ∩ A) Intersect phones (B) and emails (A)",
                intersectBA);

        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phonecContacts);
        printData("(A - B) emails (A) minus phones (B)",
                AMinusB);

        Set<Contact> BMinusA = new HashSet<>(phonecContacts);
        BMinusA.removeAll(emailContacts);
        printData("(B - A) emails (B) minus phones (A)",
                BMinusA);

        Set<Contact> symmetricDiff = new HashSet<>(AMinusB);
        symmetricDiff.addAll(BMinusA);
        printData("Symmetric Difference: phones and emails", symmetricDiff);

        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);
        printData("Symmetric Difference: phones and emails", symmetricDiff2);



    }

    public static void printData(String header, Collection<Contact> contacts) {

        System.out.println("---".repeat(15));
        System.out.println(header);
        System.out.println("---".repeat(15));
        contacts.forEach(System.out::println);
    }
}
