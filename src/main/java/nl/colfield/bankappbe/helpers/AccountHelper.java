package nl.colfield.bankappbe.helpers;

public class AccountHelper {
	
	public String createIBAN() {
		//example format: NL02ABNA0123456789 = landcode+controlegetal+bancode+rekeningNummer
		String IBAN;
		String landcode = "NL";
		String controlegetal = "02";
		String bankCode = "YCBA";//young Colfield bankers association
		
		do {
			IBAN = landcode+controlegetal+bankCode+createRekeningNummer();
		}while(CheckIfIBANExists(IBAN));
		
		return IBAN;
	}
	
	private String createRekeningNummer() {
		String rekeningnummer;
		long tempRekeningNummer = (long) (Math.random() * (9999999999.00));
		rekeningnummer = Long.toString(tempRekeningNummer);
		return rekeningnummer;
	}
	
	private boolean CheckIfIBANExists(String IBAN) {
		//logica moet nog worden toegevoegd
		return false;
	}

}
