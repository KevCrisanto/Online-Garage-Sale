import { CookieService } from 'ngx-cookie-service';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Account } from '../../objects/account';
import { Address } from '../../objects/address';
import { UserService } from '../../services/user.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  @ViewChild('content') content: ElementRef;
  closeResult: string;

  account: Account;
  address = new Address('', '', '', '', '', '', '', '', null);

  public detVisible = true;
  public formVisible = false;

  public addDetVisible = true;
  public addVisible = false;

  public showForm() {
    this.detVisible = !this.detVisible;
    this.formVisible = !this.formVisible;
  }

  public showAddForm() {
    this.addDetVisible = !this.addDetVisible;
    this.addVisible = !this.addVisible;
  }

  constructor(
    private login: LoginService,
    private cookieService: CookieService,
    private user: UserService,
    private modalService: NgbModal
  ) {}

  ngOnInit() {
    this.login.currentAccount.subscribe(account => (this.account = account));
  }

  update(a: Account) {
    this.login.updateService(this.account).subscribe(
      data => {
        if (data != null) {
          this.login.changeAccount(data);
        }
      },
      error => {
        console.log('error');
      }
    );
    this.showForm();
  }

  updateAddress(a: Address) {
    this.login.addressService(this.address).subscribe();
  }

  upgrade(id: String) {
    this.user.upgradeUser(id).subscribe();
    location.reload();
  }

  open(content) {
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title' })
      .result.then(
        result => {
          this.closeResult = `Closed with: ${result}`;
        },
        reason => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
}
