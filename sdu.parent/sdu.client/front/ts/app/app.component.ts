import {Component, OnInit} from "@angular/core";
import "rxjs/add/operator/toPromise";
import {HttpService} from "../service/HttpService";
import {IntroduceInfo} from "../model/IntroductionInfo";
import {error} from "util";

@Component({
    selector: 'helpdesk-app',
    template: `<button (click)="getIntroduce()">Introduce yourself to world</button>
        <div *ngIf="showIntroduce">{{showText}}</div>  
        `
})
export class AppComponent implements OnInit {
    showIntroduce: boolean;
    showText: string;

    ngOnInit(): void {
        console.log('on init');
    }

    constructor(private httpService: HttpService) {
        this.showIntroduce = false;
    }

    getIntroduce() {
        if (this.showIntroduce == true) {
            this.showIntroduce = false;
        } else {
            console.log("1")
            this.httpService.get("/introduction/helloWorld").toPromise().then(result => {
                let introductionInfo = result.json() as IntroduceInfo;
                if (introductionInfo) {
                    this.showText = introductionInfo.introductionText;
                    this.showIntroduce = true;
                }
            }, error => {
                console.log(error);
            })
        }
    }
}
