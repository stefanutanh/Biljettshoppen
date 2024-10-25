Det står; 
"Ta gärna foton eller skärm-dumpar på delar av er SDLC (Software/System Development Life Cycle)
process eller för anteckningar, som en slags dagbok som ni sedan kan hänvisa till under
presentationen. En vägg full med post-it lappar? En “whiteboard” fullkladdad med brainstorming?
DevSecOps (Github, GitLab, Azure DevOps, ...). Datorer som utför SUT (System Under Test)?"
i projektuppgiftsPDFen, så tänkte att vi kan skriva upp våra user stories/cases här och brainstorma osv, så har vi något att visa sen på presentationen!

User stories
1. Jag vill kunna se vilka lediga platser som finns så att jag kan välja vilken plats jag vill köpa.
   Användaren/kunden ska kunna se en översikt över alla lediga och upptagna platser på ett evenemang.

2. Jag vill kunna avbryta min bokning om jag ändrar mig.
   Användaren ska kunna avbryta sin bokning och platserna ska bli tillgängliga för andra användare.

3. Jag vill kunna boka en eller flera biljetter.
   Användaren ska kunna boka max 5 biljetter, inom en tidsgräns på 10 minuter.

4. Jag vill kunna betala med antingen faktura eller direktbetalning.
   Användaren ska kunna betala direkt eller med faktura. Köpet måste gå igenom inom 10 minuter annars avbryts köpet.

5. Jag vill bli notifierad om när bokningen gått ut på tid så att jag vet att den inte längre är tillgänglig.
   Användaren ska få en notis om att 10 minuter har gått och att deras bokning blivit avbruten.

6. Administratören ska kunna lägga till nya evenemang så att användare kan köpa biljetter till uppkommande evenemang.
   Administratören ska kunna skapa ett evenemang med datum, tid och antal biljetter.
7. Jag vill som användare kunna se mina bokade biljetter.
   Användaren ska ha tillgång till "Mina biljetter"-sida där alla bokade biljetter visas med tid/datum/plats. Biljetten ska kunna laddas ner eller visas för utskrift.

Use cases

1. Boka biljetter
   Beskrivning: Kunden väljer platser och bokar biljetter.
   Steg;
   1. Kunden väljer max 5 platser.
   2. Systemet reserverar platserna och startar en timer på 10 minuter.
   3. Kunden bekräftar bokning och väljer en betalningsmetod (antingen direktbetalning eller faktura).
   4. Betalningen bekräftas om bokningen sker inom tidsgränsen på 10 minuter. Annars avbryts bokningen om tiden går ut utan betalning.
