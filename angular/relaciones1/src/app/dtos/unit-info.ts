import { RelationInfo } from './relation-info';
import { RecordInfo } from './record-info';

export class UnitInfo {
    id: number;
    name: string;
    relations: RelationInfo[];
    records: RecordInfo[];
}